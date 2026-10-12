import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  loading = false;
  errorMessage = '';

  constructor(
    private fb: FormBuilder,
    private loginService: LoginService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.invalid) return;

    this.loading = true;
    this.errorMessage = '';

    const credentials = this.loginForm.value;

    this.loginService.login(credentials).subscribe({
      next: (response) => {
        this.loading = false;
        console.log('✅ Login success:', response);

        // Store token if needed
        // localStorage.setItem('token', response.token);

        // Navigate to dashboard (or home)
        localStorage.setItem('userEmail', response.email);
        this.router.navigate(['/profile']);
      },
      error: (error) => {
        this.loading = false;
        console.error('❌ Login failed:', error);
        this.errorMessage = error.error?.message || 'Invalid email or password.';
      }
    });
  }
}
