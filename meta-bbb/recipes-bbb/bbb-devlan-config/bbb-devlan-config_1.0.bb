SUMMARY = "BBB dev LAN static network configuration (systemd-networkd)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
    file://10-deveth0.link \
    file://10-devusb0.link \
    file://20-br0.netdev \
    file://20-br0.network \
    file://30-devusb0.network \
    file://30-deveth0.network \
"

S = "${WORKDIR}"

inherit systemd

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/*.link ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/*.network ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/*.netdev ${D}${sysconfdir}/systemd/network/
}

FILES:${PN} += "${sysconfdir}/systemd/network/*"
