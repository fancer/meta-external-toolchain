SUMMARY = "The GNU Compiler Collection"
HOMEPAGE = "http://www.gnu.org/software/gcc/"
SECTION = "devel"
GCC_VERSION := "${@external_run(d, 'gcc', '-dumpversion').rstrip()}"
PV = "${GCC_VERSION}"

gcc_binaries = "gcc gcc-${@'${PV}'.replace('${EXTERNAL_PV_SUFFIX}', '')} \
                gcc-ar gcc-nm gcc-ranlib cc gcov gcov-tool c++ g++ cpp gfortran"
