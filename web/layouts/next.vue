<template>
  <!-- This example requires Tailwind CSS v2.0+ -->
  <div class="flex h-screen overflow-hidden bg-gray-800 debug-screens">
    <div>
      <transition
        enter-active-class="transition duration-100 ease-out"
        enter-class="transform scale-95 opacity-0"
        enter-to-class="transform scale-100 opacity-100"
        leave-active-class="transition duration-75 ease-in"
        leave-class="transform scale-100 opacity-100"
        leave-to-class="transform scale-95 opacity-0"
      >
        <div
          v-show="showProfile"
          id="modal"
          style="backdrop-filter: blur(10px)"
          class="py-12 transition duration-150 ease-in-out z-10 absolute top-0 right-0 bottom-0 left-0"
        >
          <div
            v-if="showProfile"
            role="alert"
            class="container mx-auto w-11/12 md:w-2/3 max-w-lg"
          >
            <div
              class="relative md:w-80 rounded shadow-lg p-6 dark:bg-gray-800 bg-white"
            >
              <h1 class="dark:text-gray-100 text-gray-800 font-bold text-lg">
                Privacy Notice
              </h1>
              <p class="pt-6 text-xs font-semibold text-indigo-700">
                IMPORTANT
              </p>
              <p
                class="py-4 text-base font-medium dark:text-gray-100 text-gray-800"
              >
                Your backups may have personal data*
              </p>
              <p
                class="text-sm font-medium dark:text-gray-100 text-gray-600 pb-4"
              >
                *This data is viewable by everyone
              </p>
              <p class="text-xs leading-3 dark:text-gray-100 text-gray-400">
                *This data is viewable by everyone
              </p>
              <div class="sm:flex items-center justify-between pt-6">
                <button
                  class="py-3.5 px-10 dark:text-gray-100 text-gray-600 focus:outline-none hover:opacity-90 text-sm font-semibold border border-gray-600 rounded"
                  @click="showProfile = !showProfile"
                >
                  Dismiss
                </button>
                <button
                  class="py-3.5 px-5 sm:mt-0 mt-4 text-white focus:outline-none hover:opacity-90 rounded border text-sm font-semibold border-indigo-700 bg-indigo-700"
                >
                  Sounds Good
                </button>
              </div>
              <div
                class="cursor-pointer absolute top-0 right-0 mt-4 mr-5 dark:text-gray-100 text-gray-400 hover: dark:text-gray-100 text-gray-600 transition duration-150 ease-in-out"
                @click="showProfile = !showProfile"
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  aria-label="Close"
                  class="icon icon-tabler icon-tabler-x"
                  width="20"
                  height="20"
                  viewBox="0 0 24 24"
                  stroke-width="2.5"
                  stroke="currentColor"
                  fill="none"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                >
                  <path stroke="none" d="M0 0h24v24H0z" />
                  <line x1="18" y1="6" x2="6" y2="18" />
                  <line x1="6" y1="6" x2="18" y2="18" />
                </svg>
              </div>
            </div>
          </div>
        </div>
      </transition>
    </div>

    <!-- Off-canvas menu for mobile, show/hide based on off-canvas menu state. -->
    <div v-show="other" class="lg:hidden">
      <div class="fixed inset-0 z-40 flex transition-300">
        <transition
          enter-active-class="transition-opacity duration-300 ease-linear"
          enter-class="opacity-0"
          enter-to-class="opacity-100"
          leave-active-class="transition-opacity duration-300 ease-linear"
          leave-class="opacity-100"
          leave-to-class="opacity-0"
        >
          <div v-show="showMobileMenu" class="fixed inset-0">
            <div
              class="absolute inset-0 bg-gray-600 opacity-75"
              @click="closeMobileMenu()"
            ></div>
          </div>
        </transition>
        <transition
          enter-active-class="transition duration-300 ease-in-out transform"
          enter-class="-translate-x-full"
          enter-to-class="translate-x-0"
          leave-active-class="transition duration-300 ease-in-out transform"
          leave-class="translate-x-0"
          leave-to-class="-translate-x-full"
        >
          <div
            v-show="showMobileMenu"
            class="relative flex flex-col flex-1 w-full max-w-xs bg-gray-800"
          >
            <transition
              enter-active-class="transition-opacity duration-300 ease-linear"
              enter-class="opacity-0"
              enter-to-class="opacity-100"
              leave-active-class="transition-opacity duration-300 ease-linear"
              leave-class="opacity-100"
              leave-to-class="opacity-0"
            >
              <div
                v-if="showMobileMenu"
                class="absolute top-0 right-0 pt-3 -mr-12"
              >
                <button
                  class="flex items-center justify-center w-10 h-10 ml-1 rounded-full focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white"
                  @click="closeMobileMenu()"
                >
                  <span class="sr-only">Close sidebar</span>
                  <!-- Heroicon name: x -->
                  <svg
                    class="w-6 h-6 text-white"
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    aria-hidden="true"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M6 18L18 6M6 6l12 12"
                    />
                  </svg>
                </button>
              </div>
            </transition>

            <div class="flex-1 h-0 pt-5 pb-4 overflow-y-auto">
              <div class="flex items-center flex-shrink-0 px-4">
                <img
                  class="w-auto h-8"
                  src="~/assets/Audally-logo.svg"
                  alt=""
                />
              </div>
              <nav class="px-2 mt-5 space-y-1">
                <!-- Current: "bg-gray-900 text-white", Default: "text-gray-300 hover:bg-gray-700 hover:text-white" -->
                <nuxt-link
                  to="/"
                  :class="
                    $route.path === '/'
                      ? 'text-white bg-gray-900'
                      : ' text-gray-300 hover:bg-gray-700 hover:text-white focus:bg-gray-900'
                  "
                  class="flex items-center px-2 py-2 text-base font-medium rounded-md group"
                  @click.native="closeMobileMenu()"
                >
                  <!-- Current: "text-gray-300", Default: "text-gray-400 group-hover:text-gray-300" -->
                  <!-- Heroicon name: home -->
                  <svg
                    class="w-6 h-6 mr-4 text-gray-300"
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    aria-hidden="true"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6"
                    />
                  </svg>
                  Home
                </nuxt-link>

                <nuxt-link
                  to="/explore"
                  :class="
                    $route.path === '/explore'
                      ? 'text-white bg-gray-900'
                      : ' text-gray-300 hover:bg-gray-700 hover:text-white focus:bg-gray-900'
                  "
                  class="flex items-center px-2 py-2 text-base font-medium rounded-md group"
                  @click.native="closeMobileMenu()"
                >
                  <!-- Heroicon name: search -->
                  <svg
                    class="w-6 h-6 mr-4 text-gray-400 group-hover:text-gray-300"
                    fill="none"
                    stroke="currentColor"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
                    ></path>
                  </svg>
                  Explore
                </nuxt-link>

                <nuxt-link
                  to="/courses"
                  :class="
                    $route.path === '/courses'
                      ? 'text-white bg-gray-900'
                      : ' text-gray-300 hover:bg-gray-700 hover:text-white focus:bg-gray-900'
                  "
                  class="flex items-center px-2 py-2 text-base font-medium rounded-md group"
                  @click.native="closeMobileMenu()"
                >
                  <!-- Heroicon name: bookmark-alt -->
                  <svg
                    class="w-6 h-6 mr-4 text-gray-400 group-hover:text-gray-300"
                    fill="none"
                    stroke="currentColor"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M16 4v12l-4-2-4 2V4M6 20h12a2 2 0 002-2V6a2 2 0 00-2-2H6a2 2 0 00-2 2v12a2 2 0 002 2z"
                    ></path>
                  </svg>
                  My Courses
                </nuxt-link>
              </nav>
            </div>
          </div>
        </transition>
        <div class="flex-shrink-0 w-20">
          <!-- Force sidebar to shrink to fit close icon -->
        </div>
      </div>
    </div>

    <!-- Static sidebar for desktop -->
    <div class="hidden lg:flex lg:flex-shrink-0">
      <div class="flex flex-col w-64">
        <!-- Sidebar component, swap this element with another sidebar if you like -->
        <div class="flex flex-col flex-1 h-0 bg-gray-800">
          <div class="flex flex-col flex-1 pt-6 pb-4 overflow-y-auto">
            <div class="flex items-center flex-shrink-0 px-4">
              <img class="w-auto h-8" src="~/assets/Audally-logo.svg" alt="" />
            </div>
            <!-- User account dropdown -->
            <div class="relative inline-block px-2 mt-6 text-left">
              <!-- Login / Register Button -->
              <LoginButton v-if="!$auth.loggedIn"></LoginButton>
              <!-- Dropdown menu toggle, controlling the show/hide state of dropdown menu. -->
              <button
                v-else
                id="options-menu"
                type="button"
                class="w-full px-3 py-2 text-sm font-medium text-white bg-gray-900 rounded-md group hover:shadow-inner focus:shadown-outline hover:bg-opacity-100 focus:bg-gray-700"
                aria-haspopup="true"
                aria-expanded="true"
                @click="showProfileDropdown = !showProfileDropdown"
              >
                <span class="flex items-center justify-between w-full">
                  <span
                    class="flex items-center justify-between min-w-0 space-x-3"
                  >
                    <img
                      class="flex-shrink-0 w-10 h-10 bg-gray-300 rounded-full"
                      src="https://images.unsplash.com/photo-1502685104226-ee32379fefbe?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
                      alt=""
                    />
                    <span class="flex-1 min-w-0">
                      <span
                        class="text-sm font-medium text-gray-200 truncate"
                        >{{ this.$auth.user.name }}</span
                      >
                    </span>
                  </span>
                  <!-- Heroicon name: selector -->
                  <svg
                    class="flex-shrink-0 w-5 h-5 text-gray-400 group-hover:text-gray-500"
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 20 20"
                    fill="currentColor"
                    aria-hidden="true"
                  >
                    <path
                      fill-rule="evenodd"
                      d="M10 3a1 1 0 01.707.293l3 3a1 1 0 01-1.414 1.414L10 5.414 7.707 7.707a1 1 0 01-1.414-1.414l3-3A1 1 0 0110 3zm-3.707 9.293a1 1 0 011.414 0L10 14.586l2.293-2.293a1 1 0 011.414 1.414l-3 3a1 1 0 01-1.414 0l-3-3a1 1 0 010-1.414z"
                      clip-rule="evenodd"
                    />
                  </svg>
                </span>
              </button>
              <!--
            Dropdown panel, show/hide based on dropdown state.

            Entering: "transition ease-out duration-100"
              From: "transform opacity-0 scale-95"
              To: "transform opacity-100 scale-100"
            Leaving: "transition ease-in duration-75"
              From: "transform opacity-100 scale-100"
              To: "transform opacity-0 scale-95"
          -->
              <transition
                enter-active-class="transition duration-100 ease-out"
                enter-class="transform scale-95 opacity-0"
                enter-to-class="transform scale-100 opacity-100"
                leave-active-class="transition duration-75 ease-in"
                leave-class="transform scale-100 opacity-100"
                leave-to-class="transform scale-95 opacity-0"
              >
                <div
                  v-show="showProfileDropdown"
                  class="absolute left-0 right-0 z-10 mx-3 mt-1 origin-top bg-white divide-y divide-gray-200 rounded-md shadow-lg ring-1 ring-black ring-opacity-5"
                  role="menu"
                  aria-orientation="vertical"
                  aria-labelledby="options-menu"
                >
                  <div class="py-1">
                    <button
                      href="#"
                      class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                      role="menuitem"
                      @click="toggleProfile()"
                    >
                      View profile
                    </button>
                    <a
                      href="#"
                      class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                      role="menuitem"
                      >Settings</a
                    >
                    <a
                      href="#"
                      class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                      role="menuitem"
                      >Notifications</a
                    >
                  </div>
                  <div class="py-1">
                    <a
                      href="#"
                      class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                      role="menuitem"
                      >Get desktop app</a
                    >
                    <a
                      href=""
                      class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                      role="menuitem"
                      >Support</a
                    >
                  </div>
                  <div class="py-1">
                    <LogoutButton></LogoutButton>
                  </div>
                </div>
              </transition>
            </div>
            <!-- Navigation -->
            <nav class="flex-1 px-2 mt-5 space-y-1 bg-gray-800">
              <!-- Current: "bg-gray-900 text-white", Default: "text-gray-300 hover:bg-gray-700 hover:text-white" -->
              <nuxt-link
                to="/"
                class="flex items-center px-2 py-2 text-sm font-medium rounded-md group"
                :class="
                  $route.path === '/'
                    ? 'text-white bg-gray-900'
                    : ' text-gray-300 hover:bg-gray-700 hover:text-white focus:bg-gray-900'
                "
              >
                <!-- Current: "text-gray-300", Default: "text-gray-400 group-hover:text-gray-300" -->
                <!-- Heroicon name: home -->
                <svg
                  class="w-6 h-6 mr-3 text-gray-300"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  stroke="currentColor"
                  aria-hidden="true"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6"
                  />
                </svg>
                Home
              </nuxt-link>

              <nuxt-link
                :class="
                  $route.path === '/explore'
                    ? 'text-white bg-gray-900'
                    : ' text-gray-300 hover:bg-gray-700 hover:text-white focus:bg-gray-900'
                "
                to="explore"
                class="flex items-center px-2 py-2 text-sm font-medium rounded-md group"
              >
                <!-- Heroicon name: search -->
                <svg
                  class="w-6 h-6 mr-3 text-gray-400 group-hover:text-gray-300"
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
                  ></path>
                </svg>
                Explore
              </nuxt-link>

              <nuxt-link
                :class="
                  $route.path === '/courses'
                    ? 'text-white bg-gray-900'
                    : ' text-gray-300 hover:bg-gray-700 hover:text-white focus:bg-gray-900'
                "
                class="flex items-center px-2 py-2 text-sm rounded-md font-mediu group"
                to="/courses"
              >
                <!-- Heroicon name: bookmark-alt -->
                <svg
                  class="w-6 h-6 mr-3 text-gray-400 group-hover:text-gray-300"
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M16 4v12l-4-2-4 2V4M6 20h12a2 2 0 002-2V6a2 2 0 00-2-2H6a2 2 0 00-2 2v12a2 2 0 002 2z"
                  ></path>
                </svg>
                My Courses
              </nuxt-link>
            </nav>
          </div>
        </div>
      </div>
    </div>
    <div class="flex flex-col flex-1 w-0 overflow-hidden">
      <!-- Mobile Header -->
      <div
        class="relative z-10 flex flex-shrink-0 h-16 border-b border-gray-700 lg:hidden"
      >
        <!-- Sidebar toggle, controls the 'sidebarOpen' sidebar state. -->
        <button
          class="px-4 text-gray-500 border-r-8 border-transparent focus:outline-none focus:ring-2 focus:ring-inset focus:ring-purple-500 lg:hidden"
          @click="openMobileMenu()"
        >
          <span class="sr-only">Open sidebar</span>
          <!-- Heroicon name: menu-alt-1 -->
          <svg
            class="w-6 h-6"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
            aria-hidden="true"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M4 6h16M4 12h8m-8 6h16"
            />
          </svg>
        </button>
        <div class="flex justify-between flex-1">
          <div class="flex justify-center flex-1 p-4">
            <img src="~/assets/Audally-logo-letter.svg" alt="" />
          </div>
          <div class="flex items-center">
            <!-- Profile dropdown -->
            <div v-if="!logged" class="relative">
              <div>
                <button
                  id="user-menu"
                  class="flex items-center max-w-xs text-sm rounded-full focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500"
                  aria-haspopup="true"
                  @click="logged = !logged"
                >
                  <span class="sr-only">Open user menu</span>
                  <div class="px-4 text-gray-500">
                    <svg
                      class="w-6 h-6"
                      fill="none"
                      stroke="currentColor"
                      viewBox="0 0 24 24"
                      xmlns="http://www.w3.org/2000/svg"
                    >
                      <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        stroke-width="2"
                        d="M11 16l-4-4m0 0l4-4m-4 4h14m-5 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h7a3 3 0 013 3v1"
                      ></path>
                    </svg>
                  </div>
                </button>
              </div>
            </div>
            <div v-if="logged" class="relative px-4">
              <div>
                <button
                  id="user-menu"
                  class="flex items-center max-w-xs text-sm rounded-full focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500"
                  aria-haspopup="true"
                  @click="showProfileDropdown = !showProfileDropdown"
                >
                  <span class="sr-only">Open user menu</span>
                  <img
                    class="w-8 h-8 rounded-full"
                    src="https://images.unsplash.com/photo-1502685104226-ee32379fefbe?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"
                    alt=""
                  />
                </button>
              </div>
              <!--
                Profile dropdown panel, show/hide based on dropdown state.

                Entering: "transition ease-out duration-100"
                  From: "transform opacity-0 scale-95"
                  To: "transform opacity-100 scale-100"
                Leaving: "transition ease-in duration-75"
                  From: "transform opacity-100 scale-100"
                  To: "transform opacity-0 scale-95"
              -->
              <transition
                enter-active-class="transition duration-100 ease-out"
                enter-class="transform scale-95 opacity-0"
                enter-to-class="transform scale-100 opacity-100"
                leave-active-class="transition duration-75 ease-in"
                leave-class="transform scale-100 opacity-100"
                leave-to-class="transform scale-95 opacity-0"
              >
                <div
                  v-show="showProfileDropdown"
                  class="absolute right-0 w-48 mt-2 origin-top-right bg-white divide-y divide-gray-200 rounded-md shadow-lg ring-1 ring-black ring-opacity-5"
                  role="menu"
                  aria-orientation="vertical"
                  aria-labelledby="user-menu"
                >
                  <div class="py-1" role="none">
                    <a
                      href="#"
                      class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                      role="menuitem"
                      >View profile</a
                    >
                    <a
                      href="#"
                      class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                      role="menuitem"
                      >Settings</a
                    >
                    <a
                      href="#"
                      class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                      role="menuitem"
                      >Notifications</a
                    >
                  </div>
                  <div class="py-1" role="none">
                    <a
                      href="#"
                      class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                      role="menuitem"
                      >Get desktop app</a
                    >
                    <a
                      href="#"
                      class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                      role="menuitem"
                      >Support</a
                    >
                  </div>
                  <div class="py-1" role="none">
                    <LogoutButton></LogoutButton>
                  </div>
                </div>
              </transition>
            </div>
            <!--              <button
                v-if="logged"
                id="options-menu"
                type="button"
                class="w-full px-3 py-2 text-sm font-medium text-white bg-gray-900 bg-opacity-50 rounded-md group hover:shadow-inner focus:shadown-outline hover:bg-gray-700"
                aria-haspopup="true"
                aria-expanded="true"
                @click="showProfileDropdown = !showProfileDropdown"
              > -->
          </div>
        </div>
      </div>

      <main
        class="relative z-0 flex-1 overflow-y-auto lg:border-l-2 lg:border-gray-700 focus:outline-none"
        tabindex="0"
      >
        <div
          v-show="
            lesson !== null &&
            Object.keys(lesson).length !== 0 &&
            $auth.loggedIn
          "
          class="fixed bottom-0 left-0 right-0 flex p-2 bg-gray-800 border-t-2 border-gray-700 lg:border-l-2 lg:left-64"
        >
          <div
            class="flex flex-col justify-center w-1/4 px-4 font-medium text-center text-white hover:text-gray-300"
          >
            <h3 class="truncate ... border-2 border-gray-700 rounded-full py-2">
              {{ lesson !== null ? lesson.name : '' }}
            </h3>
          </div>

          <div class="w-3/4">
            <vue-plyr
              ref="plyr"
              :emit="['pause', 'ended']"
              class="relative"
              @pause="pauseAction"
              @ended="endedAction"
            >
              <audio id="plyr" controls crossorigin playsinline preload="auto">
                <source :src="current" type="audio/mp3" />
              </audio>
            </vue-plyr>
          </div>
        </div>
        <Nuxt />
        <!--<div class="py-6">
          <div class="px-4 mx-auto max-w-7xl sm:px-6 lg:px-8">
            <h1 class="text-2xl font-semibold text-gray-900">Dashboard</h1>
          </div>
          <div class="px-4 mx-auto max-w-7xl sm:px-6 md:px-8">
            <div class="py-4">
              <div
                class="border-4 border-gray-200 border-dashed rounded-lg h-96"
              ></div>
            </div>
          </div>
        </div>-->
        <!-- Bottom Bar for Audio Player -->
      </main>
    </div>
    <script
      src="https://embed.small.chat/T016XT3HG5QC01R00TQ1HC.js"
      async
    ></script>
  </div>
</template>

<script>
export default {
  data() {
    return {
      current: '',
      audio: '',
      currentTime: null,
      logged: false,
      showMobileMenu: false,
      showProfileDropdown: false,
      showProfile: false,
      other: false,
      menuItem: [
        {
          name: 'Home',
          icon: '',
          to: '/',
        },
      ],
    }
  },
  computed: {
    lesson() {
      return this.$store.state.lesson
    },
    progress() {
      return this.$store.state.currentProgress
        ? this.$store.state.currentProgress
        : 0
    },
    user() {
      return this.$store.state.user
    },
    course() {
      return this.$store.state.currentCourse
    },
  },
  mounted() {
    this.audio = document.getElementById('plyr')

    this.$refs.plyr.player.on('pause', () => this.pauseAction())
    this.$refs.plyr.player.on('ended', () => this.endedAction())

    /*
    PUT http://localhost:8080/api/progresses/1
Content-Type: application/json

{
  "progressInSeconds": 200,
  "alreadyListened": false
} */
    /*
    this.audio.onpauseonpause = function () {
      console.log('paused')

    }
    */

    this.$nuxt.$on('updateAudio', () => {
      this.updateAudio()
    })
  },
  methods: {
    toggleProfile() {
      this.showProfile = !this.showProfile
      this.showProfileDropdown = !this.showProfileDropdown
    },
    pauseAction() {
      console.log('paused')
      const uProgress = {
        progressInSeconds: Math.floor(this.audio.currentTime),
        alreadyListened: this.progress.alreadyListened,
      }

      this.$axios.put(
        'http://localhost:8080/api/progresses/' + this.progress.id,
        uProgress
      )
      setTimeout(() => {
        fetch(
          'http://localhost:8080/api/users/' +
            this.user.id +
            '/courses/' +
            this.course.id +
            '/progresses'
        )
          .then((response) => response.json())
          .then((data) => this.$store.commit('updateProgresses', data))
      }, 150)
    },
    endedAction() {
      this.pauseAction()
    },
    updateAudio() {
      this.current =
        this.lesson.audioUrl + '#t=' + this.progress.progressInSeconds
      console.log(this.current)
      // document.getElementById('plyr').src += this.current
      this.audio.pause()
      this.audio.load()
      // this.audio.play()
    },
    openMobileMenu() {
      this.other = !this.other
      this.showMobileMenu = !this.showMobileMenu
    },
    closeMobileMenu() {
      this.showMobileMenu = !this.showMobileMenu
      /* this cant be used in setTimeout so I need to preserve the value of this in that
      I found the solution here: https://stackoverflow.com/a/14571933/12722918 */
      const that = this
      setTimeout(function () {
        that.other = false
      }, 300)
    },
  },
}
</script>

<style>
body {
  --plyr-color-main: #6b46c1;
  --plyr-audio-controls-background: #1f2937;
  --plyr-audio-control-color: white;
}
:focus {
  outline: none !important;
}
</style>
