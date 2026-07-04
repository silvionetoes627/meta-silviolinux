# ---------------------------------------------------------------------------
# silviolinux-release.bb
# Arquivos de identificação da distribuição (/etc/os-release, /etc/issue)
# ---------------------------------------------------------------------------

SUMMARY = "Arquivos de release/identificação do SilvioLinux Minimal 1.0 Aurora"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://os-release"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/os-release ${D}${sysconfdir}/os-release

    echo "SilvioLinux Minimal 1.0 (Aurora) \\n \\l" > ${D}${sysconfdir}/issue
    echo "SilvioLinux Minimal 1.0 (Aurora)" > ${D}${sysconfdir}/issue.net
}

FILES:${PN} += "${sysconfdir}/os-release ${sysconfdir}/issue ${sysconfdir}/issue.net"
