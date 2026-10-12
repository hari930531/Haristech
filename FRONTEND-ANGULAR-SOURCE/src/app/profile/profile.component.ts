import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import { UserService } from '../services/user.service';
import { MatDividerModule } from '@angular/material/divider';
import {Router} from "@angular/router";


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProfileComponent implements OnInit {

  userProfile: any;
  errorMessage = '';

  constructor(private userService: UserService,    private router: Router) {}

  ngOnInit(): void {
    const email = localStorage.getItem('userEmail');

    if (!email) {
      this.errorMessage = 'User email not found. Please login again.';
      return;
    }

    this.userService.getUserByEmail(email).subscribe({
      next: (data) => {
        this.userProfile = data;
      },
      error: (err) => {
        console.error('Failed to load user profile:', err);
        this.errorMessage = 'Failed to load profile. Try again later.';
      }
    });
  }

  logout(): void {
    localStorage.clear(); // or remove specific keys
    this.router.navigate(['/login']);
  }
}
