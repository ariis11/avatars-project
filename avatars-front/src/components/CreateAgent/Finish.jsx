import check from '../../assets/check.png';

export default function Finish() {
    return (
        <div className="finish-container">
            <img src={check} />
            <h2>Congratulations!</h2>
            <p>You just created new avatar.</p>
        </div>
    );
}