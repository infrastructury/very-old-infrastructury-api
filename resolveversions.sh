#!/bin/bash

versions=()

# Loop trough everything in the version properties folder
for d in versionProperties/*; do
  # Get the name of the version that is going to be compiled
  version=$(echo "$d" | sed "s/versionProperties\///" | sed "s/.properties//")
  javaVersion=$(grep 'java_version=' "$d" | sed "s/java_version=//")
  versions+=("{\"mc\":\"$version\",\"java\":\"$javaVersion\"}")
done

versionsJson=$(jo -a -- "${versions[@]}")

echo "matrix={\"include\":${versionsJson}}"
