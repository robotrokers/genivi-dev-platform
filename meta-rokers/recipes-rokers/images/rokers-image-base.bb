# ---------------------------------
# Adapted from meta-ivi/recipes-yocto-ivi/images/ivi-image.inc

IMAGE_INSTALL = "${CORE_IMAGE_EXTRA_INSTALL}"

EXTRA_IMAGE_FEATURES = "debug-tweaks"
EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image buildhistory

IMAGE_ROOTFS_SIZE = "8192"

IMAGE_FEATURES += " package-management"

# Create SD image symlink correctly
IMAGE_POSTPROCESS_COMMAND_imx53qsb += "rename_symlink ; "

BUILDHISTORY_COMMIT = "1"

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
"

# EOF
