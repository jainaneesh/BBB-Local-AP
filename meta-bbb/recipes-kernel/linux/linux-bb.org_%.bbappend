FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://usb-ethernet.cfg"

KERNEL_CONFIG_FRAGMENTS += "usb-ethernet.cfg"
