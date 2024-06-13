document.addEventListener('DOMContentLoaded', function() {
    const copyButtons = document.querySelectorAll('.copy-button');

    copyButtons.forEach(button => {
        button.addEventListener('click', async function() {
            const row = this.closest('tr');
            const query = row.querySelector('td:nth-child(2)').textContent;

            try {
                // Use the Clipboard API to write text to the clipboard
                await navigator.clipboard.writeText(query);
                // Change the button text to indicate that it's copied
                this.textContent = 'Copied!';
            } catch (err) {
                console.error('Unable to copy to clipboard:', err);
            }
        });
    });
});
