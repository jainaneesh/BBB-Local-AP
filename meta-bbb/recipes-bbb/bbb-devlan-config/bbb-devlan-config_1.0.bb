SUMMARY = "BBB dev LAN static network configuration (systemd-networkd)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
    file://10-devlan0.link \
    file://10-devlan0.network \
"

S = "${WORKDIR}"

inherit systemd

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/10-devlan0.link ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/10-devlan0.network ${D}${sysconfdir}/systemd/network/
}

FILES:${PN} += "${sysconfdir}/systemd/network/*"

# Ensure networkd exists in the image; package name is split on many distros
RDEPENDS:${PN} += "systemd-networkd"

SYSTEMD_SERVICE:${PN} = "systemd-networkd.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"
