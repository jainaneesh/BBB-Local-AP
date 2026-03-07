FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://usb-ethernet.cfg \
            file://disable-cpsw-switchdev.cfg \
"
do_configure:append() {
    sed -i 's/^CONFIG_USB_RTL8152=m/CONFIG_USB_RTL8152=y/' ${B}/.config
    sed -i 's/^CONFIG_TI_CPSW_SWITCHDEV=y/# CONFIG_TI_CPSW_SWITCHDEV is not set/' ${B}/.config
    oe_runmake olddefconfig
}
