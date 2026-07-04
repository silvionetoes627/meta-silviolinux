# meta-silviolinux

Camada Yocto/OpenEmbedded para a **SilvioLinux Minimal 1.0 "Aurora"** — uma
mini distribuição Linux **32-bit**, **ultra-minimalista** e **sem
gerenciador de janelas**, construída sobre o **Poky (Yocto Project 5.0
"Scarthgap")**.

## Filosofia

- Sem servidor gráfico, sem X11/Wayland, sem gerenciador de janelas.
- Apenas as ferramentas essenciais de edição e rede: `vim`, `vi`, `nano`,
  `curl` e `wget`.
- Gerenciamento de pacotes via **opkg** (formato `.ipk`).
- Sistema de arquivos raiz em **ext4**.
- Boot via **GRUB**, em modo texto puro, **sem imagem de fundo**.

## Compatibilidade

| Item              | Valor              |
|-------------------|--------------------|
| Base              | Poky (Yocto Project) 5.0 "Scarthgap" |
| Arquitetura       | 32-bit (i586 / i686, `qemux86`, `genericx86`) |
| DISTRO            | `silviolinux`      |
| Versão            | 1.0                |
| Codinome          | Aurora             |
| Init              | sysvinit           |
| Pacotes           | opkg / ipk         |
| Rootfs            | ext4               |
| Bootloader        | GRUB (sem splash)  |

## Estrutura da camada

```
meta-silviolinux/
├── conf/
│   ├── layer.conf
│   └── distro/
│       ├── silviolinux.conf     # Definição da distro SilvioLinux
│       └── sanity.conf          # Checagens de sanidade/compatibilidade
├── recipes-core/
│   ├── images/silviolinux-minimal-image.bb
│   ├── packagegroups/packagegroup-silviolinux-minimal.bb
│   └── silviolinux-release/silviolinux-release.bb
├── recipes-connectivity/
│   └── opkg-config-silviolinux/
│       ├── opkg-config-silviolinux_1.0.bb
│       └── files/
│           ├── opkg.conf
│           ├── opkg-feeds.conf
│           └── aurora.conf
├── recipes-bsp/
│   └── grub/
│       ├── grub_%.bbappend
│       └── files/grub.cfg       # GRUB sem imagem de fundo
├── wic/
│   └── silviolinux-aurora.wks   # Kickstart para gerar a imagem .ext4
├── poky-sample-conf/
│   └── local.conf               # Exemplo de poky/conf/local.conf
├── AUTHORS
├── LICENSE.txt
├── COPYING.MIT
└── README.md
```

## Como usar

1. Clone o Poky (Scarthgap) e adicione esta camada:

   ```bash
   git clone -b scarthgap https://git.yoctoproject.org/poky
   cd poky
   git clone -b aurora https://git.silviolinux.dev.br/meta-silviolinux.git
   source oe-init-build-env

   bitbake-layers add-layer ../meta-silviolinux
   ```

2. Copie o `local.conf` de exemplo:

   ```bash
   cp ../meta-silviolinux/poky-sample-conf/local.conf conf/local.conf
   ```

3. Compile a imagem:

   ```bash
   bitbake silviolinux-minimal
   ```

4. A imagem final em `.ext4` (mais o `.wic` com GRUB) estará em
   `tmp/deploy/images/qemux86/`.

## Repositórios de pacotes (opkg)

Os feeds oficiais são publicados no domínio `packages.silviolinux.dev.br`, e
configurados via:

- `/etc/opkg/opkg.conf` — configuração principal do opkg.
- `/etc/opkg/opkg-feeds.conf` — lista de feeds (`base`, `updates`, `extras`,
  `tools`).
- `/etc/opkg/aurora.conf` — configurações específicas do codinome Aurora
  (versão 1.0), incluindo espelho de fallback.

## Domínio e subdomínios do projeto

| Subdomínio                     | Finalidade                              |
|---------------------------------|------------------------------------------|
| `silviolinux.dev.br`            | Site principal do projeto                |
| `git.silviolinux.dev.br`        | GitWeb / hospedagem de código-fonte      |
| `repo.silviolinux.dev.br`        | Repositórios de Pacotes           |
| `packages.silviolinux.dev.br`        | Feeds oficiais do opkg (Aurora)          |
| `mirrors.silviolinux.dev.br`     | Espelho de pacotes (fallback)            |
| `docs.silviolinux.dev.br`       | Documentação                             |
| `download.silviolinux.dev.br`   | Download de imagens (`.ext4`, `.wic`) Empacotados Em Arquivo (.zip)    |

## Licença

Este projeto é distribuído sob a licença **MIT**. Veja `LICENSE.txt` e
`COPYING.MIT` para o texto completo, e `AUTHORS` para a lista de autores.
