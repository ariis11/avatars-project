export default function HeaderButton({ activeButtonName, onButtonClick, title }) {
    return (
        <button
            className={activeButtonName === title ? 'selected-progress-button' : null}
            onClick={() => onButtonClick(title)}
        >
            {title}
        </button>
    );
}