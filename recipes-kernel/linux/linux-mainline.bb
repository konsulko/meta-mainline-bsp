inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# Build kernel v4.15-rc1
KBRANCH ?= "master"
# v4.15-rc1 tag
SRCREV ?= "4fbd8d194f06c8a3fd2af1ce560ddb31f7ec8323"
LINUX_VERSION ?= "4.15-rc1"
LINUX_VERSION_EXTENSION = "-m3ulcb"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;nocheckout=1;branch=${KBRANCH}" 
SRC_URI += "file://defconfig"
KCONFIG_MODE="--alldefconfig"

PV = "${LINUX_VERSION}+git${SRCPV}"

PROVIDES ?= "virtual/kernel"
DEPENDS += "util-linux-native openssl-native openssl"

# Default to M3ULCB
COMPATIBLE_MACHINE_m3ulcb ?= "m3ulcb"
KERNEL_DEVICETREE ?= "renesas/r8a7796-m3ulcb.dtb"
