#!/bin/bash

SCRIPT=$(realpath "$0")
SCRIPT_PATH=$(dirname "$SCRIPT")
MAPPINGS_PATH="$(dirname "$SCRIPT_PATH")"

version="$1"
filePath="$MAPPINGS_PATH/arch_$version.tiny"
tmpPath="$SCRIPT_PATH/tmp.jar"

echo "tiny	2	0	official	named" > "$filePath"
echo "Fetching https://maven.architectury.dev/dev/architectury/architectury/$version/architectury-$version.jar ..."
curl "https://maven.architectury.dev/dev/architectury/architectury/$version/architectury-$version.jar" -o "$tmpPath"

jar tf "$tmpPath" | while IFS= read -r line; do
  if [[ $line == *.class ]]; then
    noClass="${line//\.class/}"
    remapped="${noClass//dev\//remapped\/}"
    echo -e "c\t$noClass\t$remapped" >> "$filePath"
  fi
done

rm "$tmpPath"
