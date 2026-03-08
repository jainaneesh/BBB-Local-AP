FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://usb-ethernet.cfg \
            file://disable-cpsw-switchdev.cfg \
            file://am335x-boneblack-bbbrouter.dts \
"

do_configure:append() {
    sed -i 's/^CONFIG_USB_RTL8152=m/CONFIG_USB_RTL8152=y/' ${B}/.config
    sed -i 's/^CONFIG_TI_CPSW_SWITCHDEV=y/# CONFIG_TI_CPSW_SWITCHDEV is not set/' ${B}/.config
    oe_runmake olddefconfig
}
KERNEL_DEVICETREE:append:bsp-bb_org-6_12 = " ti/omap/am335x-boneblack-bbbrouter.dtb"

do_configure:append() {
    install -m 0644 ${WORKDIR}/am335x-boneblack-bbbrouter.dts \
        ${S}/arch/arm/boot/dts/ti/omap/am335x-boneblack-bbbrouter.dts
}
