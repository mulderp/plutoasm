#!/bin/bash

rm code/*
java -Xmx500M -cp "/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH" org.antlr.v4.Tool  SimpleAsm.g4 -o code/
