import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const adminGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);

  console.log("executing authguard", sessionStorage.getItem("isLoggedIn"));

  const userLoggedIn = sessionStorage.getItem("isLoggedIn");
  const isAdmin=sessionStorage.getItem("admin");
  if (userLoggedIn === 'true' && isAdmin==='true') {
  
    
    return true;

  }

  else {

    router.navigate(['/product']);
    return false;

  }
};
