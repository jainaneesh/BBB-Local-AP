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

inherit deploy

do_deploy(){
	install -d ${DEPLOY_DIR_IMAGE}
	cp -v ${IMGDEPLOYDIR}/*.wic ${DEPLOY_DIR_IMAGE}/ || true
	cp -v ${IMGDEPLOYDIR}/*.ext4 ${DEPLOY_DIR_IMAGE}/ || true
	cp -v ${IMGDEPLOYDIR}/*.tar.* ${DEPLOY_DIR_IMAGE}/ || true
}

addtask deploy after do_image_complete
