#!/bin/sh

cd ../images
cd */
mkdir -p Littlebits\ Bitcraft.app/Contents/PlugIns/Java.runtime/Contents/Home/jre/bin
cp $JAVA_HOME/jre/bin/* Littlebits\ Bitcraft.app/Contents/PlugIns/Java.runtime/Contents/Home/jre/bin/
