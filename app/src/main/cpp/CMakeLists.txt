cmake_minimum_required(VERSION 3.10.2)

project("unicorn_java")

#include_directories(include)
#include_directories(include/unicorn)

#LINK_DIRECTORIES(${PROJECT_SOURCE_DIR}/lib/armeabi-v7a)
add_library(unicorn SHARED IMPORTED)
set_target_properties(unicorn PROPERTIES IMPORTED_LOCATION
        ${PROJECT_SOURCE_DIR}/libs/${CMAKE_ANDROID_ARCH_ABI}/libunicorn.so)

add_library(
        unicorn_java
        SHARED
#        unicorn.c
        unicorn_Unicorn.c
)

find_library(
        log-lib
        log)

target_link_libraries(
        unicorn_java
        unicorn
        )
target_link_libraries(
        unicorn_java
        ${log-lib}
)