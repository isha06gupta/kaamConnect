let currentLang = "en";
let fontSizeStep = 0;

function changeLanguage(lang) {
    currentLang = lang;
    document.getElementById('lang-select').value = lang;
    document.getElementById('lang-select-mobile').value = lang;
}

function changeFontSize(delta) {
    fontSizeStep += delta;
    let base = 16 + fontSizeStep * 2;
    base = Math.min(Math.max(base, 12), 28);
    document.body.style.fontSize = base + "px";
    document.documentElement.style.fontSize = base + "px";
}

function toggleNavbar() {
    document.getElementById('mobileNav').classList.toggle('open');
}

function openLogin() {
    document.getElementById('login-modal').style.display = 'flex';
}
function closeLogin() {
    document.getElementById('login-modal').style.display = 'none';
}

function submitLogin(e) {
    e.preventDefault();
    const form = e.target;
    const username = form.querySelector('input[name="username"]').value;
    const password = form.querySelector('input[name="password"]').value;

    fetch(`/api/auth/login?lang=${currentLang}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        if (msg.includes("success")) closeLogin();
    });
}

function openForm(type) {
    fetch(`/api/form/${type}?lang=${currentLang}`)
        .then(res => res.text())
        .then(html => {
            const modal = document.getElementById('form-modal');
            const container = document.getElementById('form-container');
            container.innerHTML = html;
            modal.style.display = 'flex';
        });
}

function closeForm() {
    document.getElementById('form-modal').style.display = 'none';
    document.getElementById('form-container').innerHTML = '';
}

function submitForm(e, type) {
    e.preventDefault();
    const form = e.target;
    const formData = new FormData(form);

    fetch(`/api/register/${type}?lang=${currentLang}`, {
        method: 'POST',
        body: new URLSearchParams(formData)
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        closeForm();
    });
}

window.onclick = function(event) {
    const modal = document.getElementById('form-modal');
    const loginModal = document.getElementById('login-modal');
    const mobileNav = document.getElementById('mobileNav');
    if (event.target === modal) closeForm();
    if (event.target === loginModal) closeLogin();
    if (mobileNav.classList.contains('open') && !event.target.closest('.mobile-nav') && !event.target.classList.contains('nav-toggle')) {
        mobileNav.classList.remove('open');
    }
};

window.addEventListener('DOMContentLoaded', () => {
    document.getElementById('lang-select').value = currentLang;
    document.getElementById('lang-select-mobile').value = currentLang;
});

window.addEventListener('resize', () => {
    if (window.innerWidth > 750) {
        document.getElementById('mobileNav').classList.remove('open');
    }
});