# The Liferay Events Hook

This is a Liferay plugin that can be deployed to Liferay 6.2 or later. It is a companion plugin that goes with
the [Liferay Events mobile app](https://github.com/jamesfalkner/liferay-events-app)

# Configuring, building, and deploying the Liferay Events Hook

The Liferay Events Hook allows a Liferay server to act as an endpoint for the app, for several services related to user activities like rating a photo, "favoriting" a session, responding to a survey, or recording their presence near iBeacons.

It is a standard Liferay Hook using Maven that can be built and deployed to your Liferay server by following the [instructions in the Liferay Developer's Guide](https://dev.liferay.com/develop/tutorials/-/knowledge_base/6-2/deploying-liferay-plugins-with-maven).

Here is an example command line to build and deploy the hook to your Liferay instance (configured with the Maven profile named `liferay62ga4`).

```bash
    cd liferay-events-hook
    mvn -Pliferay62ga4 clean package liferay:deploy
```

There are some security things to know about (see the *Read/write data security* section below for details).
Part of its security relies on a *shared secret* which is shared between the mobile app (in your `tiapp.xml` file) and in the Liferay Events Hook.
You will need to ensure they match, by configuring your `build.properties` to be the same as that which you configure in Liferay using the
`liferay.events.shared.secret` portal property. To set this value, copy the `build.properties.template` file to `build.properties` and add
the secret.

The hook creates several *public* endpoints that are anonymously accessible, and several *private* endpoints requiring Basic Authentication to access. It will be accessible to any registered user on your Liferay instance, but that can be tuned with more advanced Liferay configuration and the `web.xml` file that is out of scope for this doc.

For more details on this hook, see the [Liferay Integration](https://github.com/jamesfalkner/liferay-events-app/blob/master/docs/LIFERAY.md) docs.

## Liferay Events Hook services

The Liferay Events Hook is currently designed to store its content in Liferay's Expando services, and as such, do not need any initialization or schema creation. The mobile app will *write* data to it via HTTP requests, and then
you can visualize the result by using your browser to visit the `/html/mdata-private` pages. For example, if you installed the Liferay Events Hook to a server called *company.com* on TCP port *8080*, to see the result of users using the "Add to my Agenda" session favoriting feature, you would navigate to `http://company.com:8080/html/mdata-private/liferay-favorites-service-view.jsp`.
Note that due to the configuration in the hook's `web.xml`, access to the `/mdata-private/` directory requires HTTP Basic Authentication, so your browser will ask you for a username and password, which is the same as what you would use to log into the Liferay server (it is adviseable to configure Liferay to require HTTPS).

The Liferay Events Hook "web services" are simple JSP pages and Liferay JSONWS services via ServiceBuilder.
Note that several of the JSPs make external references via `<script>` includes to various 3rd-party JavaScript libraries. You should be connected to the internet so that these libraries can be downloaded (you can also modify the hook yourself to use local copies of the libraries if you wish).

## Read/write data security

Currently the [Liferay Events mobile app](https://github.com/jamesfalkner/liferay-events-app) is completely anonymous, and as such, calls it makes to
the read-only and read/write APIs are done without authentication. Therefore, there is potential for denial-of-service abuse. To minimize that, the
read/write endpoints in this hook are designed to require *signed* API calls. API calls are signed by concatenating all of the arguments of the call,
along with a *shared secret* string, and then computing the hash of that, and sending the hash along with the API call.
The server will compute the same hash using the supplied arguments, and the two hashes must match.

For example, suppose you want to make an HTTP GET request to an endpoint of this hook, with arguments `a` and `b` and `c` set to values `1` and `2` and `3`, respectively. So something like `http://foo.com?a=1&b=2&c=3`. To sign this request,
you would concatenate the arguments (in alphabetical order) along with a a secret that must be known to both sides, for example `secret`. So you would end up with `a=1b=2c=3secret`. The SHA-256 hash of this string is `e7f7348920807e402c5911b4b39e188f61c6041d42e9a95e16b170f1646335bc`.
So the actual request would look like `http://foo.com?api_key=e7f7348920807e402c5911b4b39e188f61c6041d42e9a95e16b170f1646335bc&a=1&b=2&c=3` (but keep in mind these arguments are NOT encoded as part of the URL - they are sent via a multi-part HTTP POST).

Even with signed APIs, there is still a possibility of abuse via replay attacks. Therefore, the this hook attempts to disallow repeat requests using the exact same arguments. While not completely foolproof,
it is this author's opinion that it's "good enough" for the purposes of our use case. If you want something better, then code it up and send it in!

Furthermore, the app uses TLS at all times, via built-in support for https. The app also uses HTTP POST whenever feasible, to avoid encoding parameters into the HTTP request URLs (which show up in web server log files and elsewhere).

## How to Contribute

Just send pull requests! Also, ensure your code is bug-free, well-tested, architecturally sound, and practically perfect in *every* way.

## Future Ideas

* Use real Liferay services and web service endpoints instead of expando and JSPs
* Deliver portlets for visualization rather than raw JSPs

# Copyright and License

    Copyright (c) 2016, Liferay Inc. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
