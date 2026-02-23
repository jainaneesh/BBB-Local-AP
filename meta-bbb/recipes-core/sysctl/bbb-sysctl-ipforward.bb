SUMMARY = "Enable IPv4 forwarding for router use-case"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://99-router-ipforward.conf"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/sysctl.d
    install -m 0644 ${WORKDIR}/99-router-ipforward.conf ${D}${sysconfdir}/sysctl.d/
}

FILES:${PN} += "${sysconfdir}/sysctl.d/99-router-ipforward.conf"
