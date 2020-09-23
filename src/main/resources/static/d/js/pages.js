class DPages extends HTMLElement {
    connectedCallback() {
        this.render(window.location);
        this.unlisten = window.appHistory.listen(location =>
            this.render(location)
        );

    }

    disconnectedCallback() {
        this.unlisten();
    }

    render(location) {
        const match = location.pathname.match("/product/(.*)");
        if (match && match[1]) {
            fetch("/d/product/" + match[1])
                .then(resp => resp.text())
                .then(text => this.innerHTML = text);
        }
    }

}

window.customElements.define("d-pages", DPages);
