#!/usr/bin/env bash
# Add script to run program here.
# Complete bin/setup so that after it is
# run, bin/start can be used to launch
# it.

# This variable contains absolute path of this `start` script
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"

#This will run the application
java -jar $DIR/../target/approval-workflow-1.0-SNAPSHOT.jar $1

