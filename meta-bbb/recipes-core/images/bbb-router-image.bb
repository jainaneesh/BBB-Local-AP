SUMMARY = "Minimal BBB router / dev management hub image"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL += " \
    openssh \
    iproute2 \
    nftables \
    iptables \
    tcpdump \
    ethtool \
    bridge-utils \
    htop \
    vim \
    bbb-sysctl-ipforward \
"
