# SimplyByte

**Taste Every Byte of Technology**

Hari's Tech is an Angular + Angular Material application featuring authentication (login and registration) and a user profile experience, built with Material Design principles.

## Features
* Responsive design that adapts to different screen sizes and devices.
* Material Design components for a modern, clean user interface.
* Login and registration forms with field validation and friendly error messages.
* User profile page with configurable backend API integration.

## Getting Started

1. Install the dependencies:
   ```bash
   npm install
   ```
2. Start the development server:
   ```bash
   npm start
   ```
3. Open your browser and visit http://localhost:4200

## Configuration

The backend API URL is set in `src/assets/config.json`:

```json
{
  "apiUrl": "http://localhost:8090"
}
```

Update `apiUrl` to point to your backend.

## Build

```bash
npm run build
```

The production build is output to `dist/haristech`.

## Docker

Build and run the app as a container:

```bash
docker build -t frontend .
docker run -p 8080:80 frontend
```

Then visit http://localhost:8080

## Tech Stack

- Angular CLI: v16
- Angular Material: v16
- TypeScript: v5
- Node: v18+
