#!/usr/bin/env sh
if [ -z "$GRADLE_HOME" ]; then
    gradle "$@"
else
    "$GRADLE_HOME/bin/gradle" "$@"
fi
