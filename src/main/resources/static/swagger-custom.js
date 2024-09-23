window.onload = function() {
  // Initialize Swagger UI with the correct configuration
  const ui = SwaggerUIBundle({
    url: "/v3/api-docs",
    dom_id: '#swagger-ui',
    presets: [
      SwaggerUIBundle.presets.apis,
      SwaggerUIStandalonePreset
    ],
    layout: "StandaloneLayout"
  });

  // Disable "Try it out" button by hiding it via JS manipulation
  document.querySelectorAll('.btn.try-out__btn').forEach(function(btn) {
    btn.style.display = 'none';
  });
};
