import { Injectable } from '@angular/core';
import { MatDialog  } from '@angular/material/dialog';
import { LogoutConfirmationDialogComponent } from '../logout-confirmation-dialog/logout-confirmation-dialog.component';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {

  constructor(private dialog: MatDialog) { }

  authenticate(username: string,password: string){
    //console.log('before ' + this.isUserLoggedIn());
    if(username === 'bojan' && password === '12345'){
      sessionStorage.setItem('authenticatedUser',username);
      //console.log('after ' + this.isUserLoggedIn());
      return true;
    }
    return false;
    
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem('authenticatedUser')
    return !(user === null)
  }

  logout(){
    const dialogRef = this.dialog.open(LogoutConfirmationDialogComponent, {
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        sessionStorage.removeItem('authenticatedUser');
      }
    });
    //sessionStorage.removeItem('authenticatedUser');
  }
}
