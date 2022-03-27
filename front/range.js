module.exports = (req, res, next) => {
    res.header('Content-Range', 'trigger-campaign 0-20/20')
    next()
}