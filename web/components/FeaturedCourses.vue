<template>
  <div>
    <h1 class="px-4 text-3xl font-bold text-gray-300 sm:mb-0">
      Featured Courses
    </h1>
    <ul
      class="grid px-4 grid-cols-1 gap-6 sm:p-4 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4"
    >
      <CoursePreview
        v-for="course in courses"
        :key="course.id"
        :course="course"
        listtype="featured"
        :userid="userid"
        @addCourse="addCourse"
      ></CoursePreview>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    userid: {
      type: Number,
      default: -1,
    },
  },
  computed: {
    courses() {
      if (this.$store.state.courses === undefined) {
        return null
      }
      return this.$store.state.courses
    },
  },
  methods: {
    addCourse() {
      this.$emit('toggleToast')
    },
  },
}
</script>

<style></style>
