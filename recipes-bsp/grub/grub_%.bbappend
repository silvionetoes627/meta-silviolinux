# grub_%.bbappend
# Ajusta o GRUB do SilvioLinux para não usar imagem de fundo (menu em texto)

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://grub.cfg"

do_install:append() {
    # Garante que nenhuma imagem de fundo (splash) seja copiada para o boot
    rm -f ${D}/boot/grub/splash.xpm.gz 2>/dev/null || true
    install -d ${D}/boot/grub
    install -m 0644 ${WORKDIR}/grub.cfg ${D}/boot/grub/grub.cfg
}
