# ---------------------------------------------------------------------------
# silviolinux-minimal-image.bb
# Imagem raiz da SilvioLinux Minimal 1.0 "Aurora"
# Ultra-minimalista, sem gerenciador de janelas, apenas ferramentas essenciais.
# ---------------------------------------------------------------------------

SUMMARY = "SilvioLinux Minimal 1.0 (Aurora) - imagem raiz ultra-minimalista, sem WM"
DESCRIPTION = "Imagem base do SilvioLinux, 32-bit, apenas com vim, vi, nano, \
curl e wget. Sem servidor gráfico, sem gerenciador de janelas."
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "package-management ssh-server-dropbear read-only-rootfs-delayed-postinsts"
IMAGE_FEATURES:remove = "splash x11-base"

# Somente essas ferramentas de edição/rede + o essencial do sistema
IMAGE_INSTALL = " \
    packagegroup-core-boot \
    packagegroup-silviolinux-minimal \
    opkg \
    opkg-config-silviolinux \
    silviolinux-release \
    kernel-modules \
"

# Nada de X11/Wayland/WM
IMAGE_INSTALL:remove = "weston-init xserver-nodm-init"

# Sistema de arquivos final: ext4
IMAGE_FSTYPES = "ext4"

# Tamanho enxuto (ajuste fino de espaço livre no rootfs)
IMAGE_ROOTFS_EXTRA_SPACE = "65536"
IMAGE_OVERHEAD_FACTOR = "1.2"

# Rótulo exibido no boot / motd
IMAGE_LABEL = "SilvioLinux Minimal 1.0 (Aurora)"
