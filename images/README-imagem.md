# Imagem de exemplo: silviolinux-minimal-1.0-aurora-i586.ext4

Este arquivo é um **sistema de arquivos ext4 real** (64 MB, rótulo
`silviolinux-root`) gerado como demonstração do produto final desta camada,
já contendo o esqueleto do rootfs com:

- `/etc/os-release`, `/etc/issue`
- `/etc/opkg/opkg.conf`
- `/etc/opkg/opkg-feeds.conf`
- `/etc/opkg/aurora.conf`
- `/boot/grub/grub.cfg` (sem imagem de fundo)

> **Importante:** esta imagem é um *exemplo estrutural* criado fora do
> BitBake (com `mkfs.ext4` + `debugfs`), pois a imagem oficial e completa
> (com kernel, busybox/bash, vim, nano, curl, wget e opkg reais) só pode ser
> gerada rodando o build completo do Yocto:
>
> ```bash
> bitbake silviolinux-minimal-image
> ```
>
> O resultado oficial ficará em
> `tmp/deploy/images/qemux86/silviolinux-minimal-image-qemux86.rootfs.ext4`
> (e a variante `.wic`, com GRUB, gerada a partir de
> `wic/silviolinux-aurora.wks`).

Para inspecionar este arquivo de exemplo:

```bash
debugfs -R "ls -l /" silviolinux-minimal-1.0-aurora-i586.ext4
sudo mount -o loop silviolinux-minimal-1.0-aurora-i586.ext4 /mnt
```
