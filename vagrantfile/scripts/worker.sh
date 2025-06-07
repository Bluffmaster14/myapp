#!/bin/bash

# Wait for master to generate join script
while [ ! -f /vagrant/join.sh ]; do
  sleep 5
done

bash /vagrant/join.sh

