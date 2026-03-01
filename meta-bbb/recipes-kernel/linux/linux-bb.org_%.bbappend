FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://usb-ethernet.cfg"
do_configure:append() {
    sed -i 's/^CONFIG_USB_RTL8152=m/CONFIG_USB_RTL8152=y/' ${B}/.config
    oe_runmake olddefconfig
}
