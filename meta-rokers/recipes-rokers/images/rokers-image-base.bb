# rokers-image-base

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

EXTRA_IMAGE_FEATURES = "debug-tweaks"
EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image buildhistory

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

IMAGE_FEATURES += " package-management"
IMAGE_FEATURES += "ssh-server-openssh"

# Set default password for 'root' user
inherit extrausers
ROOTPASSWORD = "root"
ROOTUSERNAME = "root"
EXTRA_USERS_PARAMS ?= "usermod -P ${ROOTPASSWORD} ${ROOTUSERNAME};"

# ---------------------------------
# Adapted from meta-ivi/recipes-yocto-ivi/images/ivi-image.bb

PV ?= "snapshot+${DATE}"

IMAGE_INSTALL_append = " \
    busybox-udhcpc \
    hostapd \
"

# EOF
