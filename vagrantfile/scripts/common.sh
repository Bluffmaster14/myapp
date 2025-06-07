#!/bin/bash
set -e

swapoff -a
sed -i '/ swap / s/^/#/' /etc/fstab

apt-get update && apt-get install -y apt-transport-https ca-certificates curl gnupg lsb-release software-properties-common

# Create directory if it doesn't exist
mkdir -p /etc/apt/keyrings

# Download and save the Kubernetes repo key
curl -fsSL https://pkgs.k8s.io/core:/stable:/v1.30/deb/Release.key | gpg --dearmor -o /etc/apt/keyrings/kubernetes-apt-keyring.gpg

# Add the Kubernetes repo
echo "deb [signed-by=/etc/apt/keyrings/kubernetes-apt-keyring.gpg] https://pkgs.k8s.io/core:/stable:/v1.30/deb/ /" > /etc/apt/sources.list.d/kubernetes.list

apt-get update
apt-get install -y kubelet kubeadm kubectl docker.io
apt-mark hold kubelet kubeadm kubectl

systemctl enable docker
systemctl start docker
