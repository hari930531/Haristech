import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';

// Function that loads config BEFORE Angular bootstraps
function loadConfig(): Promise<any> {
  return fetch('/assets/config.json')
    .then(response => response.json())
    .then(config => {
      (window as any).appConfig = config;
      console.log('Config loaded:', config);
    })
    .catch(err => {
      console.error('Failed to load config.json:', err);
    });
}

// First load config.json, THEN bootstrap Angular
loadConfig().then(() => {
  platformBrowserDynamic()
    .bootstrapModule(AppModule)
    .catch(err => console.error(err));
});

