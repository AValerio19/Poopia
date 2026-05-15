<link rel="stylesheet" href="Assets/Css/Sidebar.component.css?v=<%= System.currentTimeMillis() %>" type="text/css" />
<link rel="stylesheet" href="Assets/Css/Global.view.css?v=<%= System.currentTimeMillis() %>" type="text/css" />

<aside class="sidebar-container">
    <div class="sidebar-links">
        <div class="sidebar-logo-container">
            <div class="sidebar-header">
                <svg viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
                    <path d="M x1 y1 A r1 r2 rx ry rn: y1 yz; y3 er: ry y1 r2... L x2 y2 C c1 c2... c1 r2 c3 y2 c2 c1 c2 c1 c1 c2 c1 c2 c3 ... Z" fill="var(--text-main)" />
                </svg>
            </div>
        </div>

        <nav class="redirection-nav">
            <ul class="redirection-list">
                <li>
                    <a href="main?p=home" class="redirection-link">
                        <span class="icon">
                            <svg viewBox="0 0 100 100" class="icon-svg ${param.p == 'home' ? 'active' : ''}" stroke="var(--text-main)" stroke-width="6" stroke-linecap="round" stroke-linejoin="round">
                                <path d="M50 15 L15 45 L15 85 H85 V45 L50 15 Z" />
                                <path d="M35 70 V70 H65" />
                            </svg>
                        </span>
                        <span class="icon-name">Inicio</span>
                    </a>
                </li>
                <li>
                    <a href="main?p=category" class="redirection-link">
                        <span class="icon">
                            <svg viewBox="0 0 100 100" class="icon-svg ${param.p == 'category' ? 'active' : ''}" stroke="var(--text-main)" stroke-width="6" stroke-linejoin="round">
                                <path d="M15 15h30v30H15z M55 15h30v30H55z M55 55h30v30H55z M15 55h30v30H15z" />
                            </svg>
                        </span>
                        <span class="icon-name">Categorias</span>
                    </a>
                </li>
                <li>
                    <a href="main?p=discover" class="redirection-link">
                        <span class="icon">
                            <svg
                                viewBox="0 0 100 100"
                                class="icon-svg ${param.p == 'discover' ? 'active' : ''}"
                                stroke="var(--text-main)"
                                stroke-width="6"
                                stroke-linecap="round"
                                stroke-linejoin="round"
                            >
                                <path d="M10 15h25a15 15 0 0 1 15 15v55a12 12 0 0 0-12-12H10z" />
                                <path d="M90 15H65a15 15 0 0 0-15 15v55a12 12 0 0 1 12-12h28z" />
                            </svg>
                        </span>
                        <span class="icon-name">Descubrir</span>
                    </a>
                </li>
                <li>
                    <a href="main?p=downloaded" class="redirection-link">
                        <span class="icon">
                            <svg
                                viewBox="0 0 100 100"
                                class="icon-svg ${param.p == 'downloaded' ? 'active' : ''}"
                                stroke="var(--text-main)"
                                stroke-width="6"
                                stroke-linecap="round"
                                stroke-linejoin="round"
                            >
                                <path d="M50 15v50 M30 45l20 20 20-20" />
                                <path d="M80 70v10a8 8 0 0 1-8 8H28a8 8 0 0 1-8-8V70" />
                            </svg>
                        </span>
                        <span class="icon-name">Descargados</span>
                    </a>
                </li>
                <li>
                    <a href="main?p=saved" class="redirection-link">
                        <span class="icon">
                            <svg viewBox="0 0 100 100" class="icon-svg ${param.p == 'saved' ? 'active' : ''}" stroke="var(--text-main)" stroke-width="6" stroke-linejoin="round">
                                <path d="M80 85l-30-20-30 20V20a8 8 0 0 1 8-8h44a8 8 0 0 1 8 8z" />
                            </svg>
                        </span>
                        <span class="icon-name">Guardados</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

    <div class="sidebar-footer">
        <nav class="redirection-nav">
            <ul class="redirection-list">
                <li>
                    <a href="main?p=login" class="redirection-link">
                        <span class="icon"><svg viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg"></svg></span>
                        <span class="icon-name">Iniciar sesion</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</aside>
