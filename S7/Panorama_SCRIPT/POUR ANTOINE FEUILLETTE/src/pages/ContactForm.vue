<template>
  <div class="contact-form">
    <h1>Contact Us</h1>
    <form>
      <label for="name">Name:</label>
      <input type="text" id="name" name="name" />

      <label for="email">Email:</label>
      <input type="email" id="email" name="email" />

      <label for="message">Message:</label>
      <textarea id="message" name="message"></textarea>

      <button type="submit">Send</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "ContactForm",
};
</script>

