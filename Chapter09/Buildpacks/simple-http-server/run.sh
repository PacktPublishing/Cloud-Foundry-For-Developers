#!/usr/bin/env bash

HTML="$(cat index.http)"
RESPONSE="HTTP/1.1 200 OK\r\nConnection: keep-alive\r\n\r\n"$HTML"\r\n"
while { echo -en "$RESPONSE" ; } | nc -l $PORT ; do
   if [ "$SIMPLE_HTTP_BP_VERBOSE" == "true" ]
   then
       echo "Sent Response: $RESPONSE"
   fi
done
