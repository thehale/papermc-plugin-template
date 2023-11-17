<!--
 Copyright (c) 2023 Joseph Hale
 
 This Source Code Form is subject to the terms of the Mozilla Public
 License, v. 2.0. If a copy of the MPL was not distributed with this
 file, You can obtain one at http://mozilla.org/MPL/2.0/.
-->

# Contributing

## Development Setup

### Install the Java Development Kit (JDK)
[Install SDKMAN!](https://sdkman.io/install) to manage Java installations

```
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
```

Install Java 17

```
sdk install java 17.0.0-tem
```

### Start the development Minecraft server

```
./gradlew runDevServer
```

This will download and start a [PaperMC server](https://papermc.io/) with your plugin installed.

#### Becoming `op`

Open Minecraft and log into the booted server.

Then run the following command in a new terminal

```
cat app/.server/logs/latest.log | grep UUID | tail -n 1 |sed "s/.*UUID of player /[{\"name\":\"/" | sed "s/ is \(.*\)/\", \"uuid\":\"\1\", \"level\":4}]/" > app/.server/ops.json
```

This will detect your username and uuid from the server logs and add you to the
`ops.json`.

You may have to restart the server for the `op` permissions to take effect.

#### Testing code changes in the dev server

You can update the plugin in the dev server with the following commands which
will rebuild your changes and push them to the dev server

```
./gradlew build
./gradlew copyPluginToDevServer
```

Then, in your Minecraft game, enter the command

```
/reload confirm
```

### Stopping the development Minecraft server

When you are done working with the server you can stop it by typing
<kbd>CTRL</kbd> + <kbd>C</kbd> in the terminal where the server is running.