const detailPagesTemplate = document.createElement('template');
detailPagesTemplate.innerHTML = `
<h1>hello detail </h1>
<a href="/">list</a>
<a href="/checkout">checkout</a>
`;

class DetailPages extends HTMLElement {

    connectedCallback() {
        this.attachShadow({ mode: 'open' });
        this.shadowRoot.appendChild(detailPagesTemplate.content.cloneNode(true));
    }
}

customElements.define('d-pages', DetailPages);