<template>
  <div class="h-screen bg-gray-800">
    <PageHeader :name="course.name" :back="true"></PageHeader>
    <div class="items-center justify-between hidden w-full lg:flex">
      <div
        class="flex flex-col items-start w-full p-4 rounded lg:p-8 lg:flex-row lg:items-center"
      >
        <div class="w-full pt-4 lg:pt-0 lg:w-2/3">
          <h1
            class="hidden text-4xl font-bold tracking-wider text-white lg:block"
          >
            {{ course.name }}
          </h1>
          <p class="mt-4 text-xl tracking-wider text-gray-300">
            {{ course.description }}
          </p>
          <p class="mt-4 text-lg tracking-wider text-gray-500">
            Lessons:
            {{ course.lessons.length }}
          </p>
        </div>
        <div
          :style="{ 'background-image': `url(${course.pictureUrl})` }"
          class="w-full h-24 bg-center bg-cover rounded-lg lg:w-1/3 lg:h-64"
        ></div>
      </div>
    </div>

    <div class="flex items-center justify-between w-full lg:hidden">
      <div
        class="flex flex-col items-start w-full p-4 rounded lg:p-8 lg:flex-row lg:items-center"
      >
        <div
          :style="{ 'background-image': `url(${course.pictureUrl})` }"
          class="w-full h-24 bg-center bg-cover rounded-lg lg:w-1/3 lg:h-64"
        ></div>
        <div class="w-full pt-4 lg:pt-0 lg:pl-8 lg:w-2/3">
          <h1
            class="hidden text-4xl font-bold tracking-wider text-white lg:block"
          >
            {{ course.name }}
          </h1>
          <p class="mt-4 text-xl tracking-wider text-gray-300">
            {{ course.description }}
          </p>
          <p class="mt-4 text-lg tracking-wider text-gray-500">
            Lessons:
            {{ course.lessons.length }}
          </p>
        </div>
      </div>
    </div>

    <!-- This example requires Tailwind CSS v2.0+ -->
    <div class="h-20 px-4 py-4 mx-auto max-w-7xl lg:px-8">
      <!-- We've used 3xl here, but feel free to try other max-widths based on your needs -->
      <div class="h-20 max-w-4xl">
        <h2 class="font-medium tracking-wide text-gray-500 uppercase text-md">
          Course Lessons
        </h2>
        <ul>
          <li
            v-for="(lesson, i) in course.lessons"
            :key="i"
            class="flex col-span-1 mt-3 rounded-md shadow-sm focus-within:ring-2 focus-within:ring-purple-500"
            :class="clesson.id === lesson.id ? 'ring-2 ring-purple-500' : ''"
            @click="play(lesson)"
          >
            <div
              class="flex items-center justify-center flex-shrink-0 p-4 text-2xl font-medium text-white bg-gray-700 w-13 rounded-l-md"
            >
              {{ i + 1 }}.
            </div>
            <div
              class="flex items-center justify-between flex-1 truncate bg-gray-700 rounded-r-md"
            >
              <div class="flex-1 px-4 py-2 truncate text-md">
                <a href="#" class="font-medium text-white hover:text-gray-300">
                  {{ lesson.name }}
                </a>
                <p class="hidden text-sm text-gray-500 lg:block">
                  {{ lesson.description }}
                </p>
                <p class="block text-sm text-gray-500 lg:hidden">
                  {{ lesson.duration }}
                </p>
              </div>
              <div
                v-if="$auth.loggedIn"
                class="flex items-center justify-center flex-shrink-0 p-4 text-gray-400"
              >
                <template
                  v-if="progresses.find((p) => p.lesson.id === lesson.id)"
                >
                  <svg
                    v-if="
                      progresses.find((p) => p.lesson.id === lesson.id)
                        .alreadyListened === true
                    "
                    class="w-6 h-6 text-green-500 mr-4"
                    fill="none"
                    stroke="currentColor"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M9 12l2 2 4-4M7.835 4.697a3.42 3.42 0 001.946-.806 3.42 3.42 0 014.438 0 3.42 3.42 0 001.946.806 3.42 3.42 0 013.138 3.138 3.42 3.42 0 00.806 1.946 3.42 3.42 0 010 4.438 3.42 3.42 0 00-.806 1.946 3.42 3.42 0 01-3.138 3.138 3.42 3.42 0 00-1.946.806 3.42 3.42 0 01-4.438 0 3.42 3.42 0 00-1.946-.806 3.42 3.42 0 01-3.138-3.138 3.42 3.42 0 00-.806-1.946 3.42 3.42 0 010-4.438 3.42 3.42 0 00.806-1.946 3.42 3.42 0 013.138-3.138z"
                    ></path>
                  </svg>
                </template>
                <p class="hidden mr-4 lg:block">
                  {{ lesson.duration }}
                </p>
                <div
                  class="inline-flex items-center justify-center w-8 h-8 text-gray-400 bg-transparent rounded-full focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                >
                  <span class="sr-only">Open options</span>
                  <!-- Heroicon name: dots-vertical -->
                  <svg
                    class="w-8 h-8"
                    fill="none"
                    stroke="currentColor"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M14.752 11.168l-3.197-2.132A1 1 0 0010 9.87v4.263a1 1 0 001.555.832l3.197-2.132a1 1 0 000-1.664z"
                    ></path>
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
                    ></path>
                  </svg>
                </div>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  async fetch() {
    await fetch(
      'http://localhost:8080/api/users/' +
        this.user.id +
        '/courses/' +
        this.course.id +
        '/progresses'
    )
      .then((response) => response.json())
      .then((data) => this.$store.commit('updateProgresses', data))
  }, // http://localhost:8080/api/users/1/courses/1/progresses
  layout: 'next',
  data() {
    return {
      player: null,
      playing: false,
      playingLesson: '',
      currentAudioUrl: '',
    }
  },
  computed: {
    course() {
      return this.$store.state.currentCourse
    },
    user() {
      return this.$store.state.user
    },
    clesson() {
      return this.$store.state.lesson === null ? {} : this.$store.state.lesson
    },
    progresses() {
      return this.$store.state.progresses
    },
  },
  mounted() {
    this.player = document.getElementById('myAudio')
  },
  methods: {
    play(lesson) {
      this.$store.commit('updateLesson', lesson)
      this.$store.commit(
        'updateProgress',
        this.progresses.find((s) => s.lesson.id === lesson.id)
      )
      this.$nuxt.$emit('updateAudio')
    },
  },
}
</script>

<style>
.left-64 {
  left: 16rem;
}
</style>
