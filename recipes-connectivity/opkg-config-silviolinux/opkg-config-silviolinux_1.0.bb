# ---------------------------------------------------------------------------
# opkg-config-silviolinux_1.0.bb
# Instala /etc/opkg/opkg.conf, opkg-feeds.conf e aurora.conf no rootfs
# ---------------------------------------------------------------------------

SUMMARY = "Configuração do gerenciador de pacotes opkg do SilvioLinux Minimal (Aurora)"
DESCRIPTION = "Fornece /etc/opkg/opkg.conf, /etc/opkg/opkg-feeds.conf e \
/etc/opkg/aurora.conf apontando para os repositórios oficiais em \
pkg.silviolinux.dev.br referentes ao codinome Aurora (versão 1.0)."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://opkg.conf \
    file://opkg-feeds.conf \
    file://aurora.conf \
"

S = "${WORKDIR}"

RDEPENDS:${PN} = "opkg"
RCONFLICTS:${PN} = "opkg-config-base"

do_install() {
    install -d ${D}${sysconfdir}/opkg
    install -m 0644 ${WORKDIR}/opkg.conf        ${D}${sysconfdir}/opkg/opkg.conf
    install -m 0644 ${WORKDIR}/opkg-feeds.conf  ${D}${sysconfdir}/opkg/opkg-feeds.conf
    install -m 0644 ${WORKDIR}/aurora.conf      ${D}${sysconfdir}/opkg/aurora.conf
}

FILES:${PN} += " \
    ${sysconfdir}/opkg/opkg.conf \
    ${sysconfdir}/opkg/opkg-feeds.conf \
    ${sysconfdir}/opkg/aurora.conf \
"

CONFFILES:${PN} += " \
    ${sysconfdir}/opkg/opkg.conf \
    ${sysconfdir}/opkg/opkg-feeds.conf \
    ${sysconfdir}/opkg/aurora.conf \
"
