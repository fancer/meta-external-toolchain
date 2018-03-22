require recipes-external/gcc/gcc-external.inc
inherit external-toolchain-cross-canadian

PN .= "-${TRANSLATED_TARGET_ARCH}"

RDEPENDS_${PN} = "binutils-external-cross-canadian-${TRANSLATED_TARGET_ARCH}"

external_libroot = "${@os.path.realpath('${EXTERNAL_TOOLCHAIN_LIBROOT}').replace(os.path.realpath('${EXTERNAL_TOOLCHAIN}') + '/', '/')}"
FILES_MIRRORS =. "${libdir}/gcc/${EXTERNAL_TARGET_SYS}/${BINV}/|${external_libroot}/\n"

# Copy all the executables, headers and crt* static files to the package
INSANE_SKIP_${PN} += "dev-so staticdev"
BINV = "${GCC_VERSION}"
FILES_${PN} += "\
    ${@' '.join('${base_bindir}/${EXTERNAL_TARGET_SYS}-' + i for i in '${gcc_binaries}'.split())} \
    ${libdir}/libcc1* \
    ${libdir}/gcc/${EXTERNAL_TARGET_SYS}/${BINV} \
    ${libexecdir}/gcc/${EXTERNAL_TARGET_SYS}/${BINV} \
"
