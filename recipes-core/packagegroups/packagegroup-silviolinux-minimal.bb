# ---------------------------------------------------------------------------
# packagegroup-silviolinux-minimal.bb
# Conjunto mínimo de pacotes do SilvioLinux: editores + ferramentas de rede
# ---------------------------------------------------------------------------

SUMMARY = "Grupo de pacotes mínimo do SilvioLinux (vim, vi, nano, curl, wget)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = " \
    vim \
    nano \
    curl \
    wget \
    busybox \
    bash \
"
# 'vi' é provido pelo pacote 'vim' (symlink vi->vim) ou pelo applet do busybox;
# ambos garantem o comando `vi` disponível no sistema final.
