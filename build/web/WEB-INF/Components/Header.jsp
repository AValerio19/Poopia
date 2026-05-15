<link rel="stylesheet" href="Assets/Css/Header.component.css?v=<%= System.currentTimeMillis() %>" type="text/css" />
<link rel="stylesheet" href="Assets/Css/Global.view.css?v=<%= System.currentTimeMillis() %>" type="text/css" />

<header>
    <div class="header-left">
        <div class="search">
            <form class="search-form" action="">
                <span class="icon icon-search">
                    <svg viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg" stroke="var(--text-main)" stroke-width="6" fill="none" stroke-linecap="round" stroke-linejoin="round">
                        <circle cx="40" cy="40" r="30"></circle>
                        <line x1="65" y1="65" x2="90" y2="90"></line>
                    </svg>
                </span>
                <input class="input-search" type="search" name="search" id="search" placeholder="Titulo, autor, genero..." />
            </form>
        </div>
    </div>
    <div class="header-right">
        <button class="header-profile">
            <div class="profile-user">info (nombre + rol: estudiante, maestro, admin...)</div>
            <div class="profile-dropdown">
                <ul>
                    <li>
                        <a href="" class="profile-link"><span>Perfil</span></a>
                    </li>
                    <li>
                        <a href="" class="profile-link"><span>Opciones</span></a>
                    </li>
                    <li>
                        <a href="" class="profile-link"><span>Cerrar sesion</span></a>
                    </li>
                </ul>
            </div>
        </button>
        <div class="header-notif">noti</div>
    </div>
</header>
